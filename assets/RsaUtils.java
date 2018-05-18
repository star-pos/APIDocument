package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;  
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;  
import java.security.KeyPair;  
import java.security.KeyPairGenerator;  
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;  
import java.security.interfaces.RSAPublicKey;  
import java.security.spec.InvalidKeySpecException;  
import java.security.spec.PKCS8EncodedKeySpec;  
import java.security.spec.X509EncodedKeySpec;  
import java.util.HashMap;  

import javax.crypto.Cipher;  

import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

import java.math.BigInteger;    
import java.security.interfaces.RSAPrivateKey;    
import java.security.spec.RSAPrivateKeySpec;    
import java.security.spec.RSAPublicKeySpec;    

public class RsaUtils {    
  
    /**  
     * ���ɹ�Կ��˽Կ  
     * @throws NoSuchAlgorithmException   
     *  
     */    
    public static HashMap<String, Object> getKeys() throws NoSuchAlgorithmException{    
        HashMap<String, Object> map = new HashMap<String, Object>();    
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");    
        keyPairGen.initialize(1024);    
        KeyPair keyPair = keyPairGen.generateKeyPair();    
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();    
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();    
        map.put("public", publicKey);    
        map.put("private", privateKey);    
        return map;    
    }    
    /**  
     * ʹ��ģ��ָ������RSA��Կ  
     * ע�⣺���˴�������Ĭ�ϲ�λ��ʽ��ΪRSA/None/PKCS1Padding����ͬJDKĬ�ϵĲ�λ��ʽ���ܲ�ͬ����AndroidĬ����RSA  
     * /None/NoPadding��  
     *   
     * @param modulus  
     *            ģ  
     * @param exponent  
     *            ָ��  
     * @return  
     */    
    public static RSAPublicKey getPublicKey(String modulus, String exponent) {    
        try {    
            BigInteger b1 = new BigInteger(modulus);    
            BigInteger b2 = new BigInteger(exponent);    
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");    
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);    
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);    
        } catch (Exception e) {    
            e.printStackTrace();    
            return null;    
        }    
    }    
    
    /**  
     * ʹ��ģ��ָ������RSA˽Կ  
     * ע�⣺���˴�������Ĭ�ϲ�λ��ʽ��ΪRSA/None/PKCS1Padding����ͬJDKĬ�ϵĲ�λ��ʽ���ܲ�ͬ����AndroidĬ����RSA  
     * /None/NoPadding��  
     *   
     * @param modulus  
     *            ģ  
     * @param exponent  
     *            ָ��  
     * @return  
     */    
    public static RSAPrivateKey getPrivateKey(String modulus, String exponent) {    
        try {    
            BigInteger b1 = new BigInteger(modulus);    
            BigInteger b2 = new BigInteger(exponent);    
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");    
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);    
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);    
        } catch (Exception e) {    
            e.printStackTrace();    
            return null;    
        }    
    }    
    
    /**  
     * ��Կ����  
     *   
     * @param data  
     * @param publicKey  
     * @return  
     * @throws Exception  
     */    
    public static String encryptByPublicKey(String data, RSAPublicKey publicKey)    
            throws Exception {    
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");    
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);    
        // ģ��    
        int key_len = publicKey.getModulus().bitLength() / 8;    
        // �������ݳ��� <= ģ��-11   
        String iosDatas = new String(data.getBytes("GBK"),"ISO-8859-1");  
        String[] datas = splitString(iosDatas, key_len - 11);    
        String mi = "";    
        //������ĳ��ȴ���ģ��-11��Ҫ�������    
        for (String s : datas) {  
            mi += byte2HexStr(cipher.doFinal(s.getBytes("ISO-8859-1")));    
        }       
//        for (String s : datas) {  
//        	mi += bcd2Str(cipher.doFinal(s.getBytes("ISO-8859-1")));    
//        }    
        return mi;    
    }    
    
    /**  
     * ˽Կ����  
     *   
     * @param data  
     * @param privateKey  
     * @return  
     * @throws Exception  
     */    
    public static String decryptByPrivateKey(String data, RSAPrivateKey privateKey)    
            throws Exception {    
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");    
        cipher.init(Cipher.DECRYPT_MODE, privateKey);    
        //ģ��    
        int key_len = privateKey.getModulus().bitLength() / 8;    
        byte[] bytes = data.getBytes("UTF-8");    
        byte[] bcd = ASCII_To_BCD(bytes, bytes.length);     
        //������ĳ��ȴ���ģ����Ҫ�������    
        String ming = "";    
        byte[][] arrays = splitArray(bcd, key_len);    
        for(byte[] arr : arrays){    
            ming += new String(cipher.doFinal(arr),"ISO-8859-1");    
        }    
        return new String(ming.getBytes("ISO-8859-1"));    
    }    
    /**  
     * ASCII��תBCD��  
     *   
     */    
    public static byte[] ASCII_To_BCD(byte[] ascii, int asc_len) {    
        byte[] bcd = new byte[asc_len / 2];    
        int j = 0;    
        for (int i = 0; i < (asc_len + 1) / 2; i++) {    
            bcd[i] = asc_to_bcd(ascii[j++]);    
            bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));    
        }    
        return bcd;    
    }    
    public static byte asc_to_bcd(byte asc) {    
        byte bcd;    
    
        if ((asc >= '0') && (asc <= '9'))    
            bcd = (byte) (asc - '0');    
        else if ((asc >= 'A') && (asc <= 'F'))    
            bcd = (byte) (asc - 'A' + 10);    
        else if ((asc >= 'a') && (asc <= 'f'))    
            bcd = (byte) (asc - 'a' + 10);    
        else    
            bcd = (byte) (asc - 48);    
        return bcd;    
    }    
    /**  
     * BCDת�ַ���  
     */    
    public static String bcd2Str(byte[] bytes) {    
        char temp[] = new char[bytes.length * 2], val;    
    
        for (int i = 0; i < bytes.length; i++) {    
            val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);    
            temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');    
    
            val = (char) (bytes[i] & 0x0f);    
            temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');    
        }    
        return new String(temp);    
    }    
    /**  
     * ����ַ���  
     */    
    public static String[] splitString(String string, int len) {    
        int x = string.length() / len;    
        int y = string.length() % len;    
        int z = 0;    
        if (y != 0) {  
            z = 1;    
        }  
        String[] strings = new String[x + z];    
        String str = "";    
        for (int i=0; i<x+z; i++) {    
            if (i==x+z-1 && y!=0) {    
                str = string.substring(i*len, i*len+y);    
            }else{    
                str = string.substring(i*len, i*len+len);    
            }  
            strings[i] = str;    
        }    
        return strings;    
    }  
    /**  
     *�������   
     */    
    public static byte[][] splitArray(byte[] data,int len){    
        int x = data.length / len;    
        int y = data.length % len;    
        int z = 0;    
        if(y!=0){    
            z = 1;    
        }    
        byte[][] arrays = new byte[x+z][];    
        byte[] arr;    
        for(int i=0; i<x+z; i++){    
            arr = new byte[len];    
            if(i==x+z-1 && y!=0){    
                System.arraycopy(data, i*len, arr, 0, y);    
            }else{    
                System.arraycopy(data, i*len, arr, 0, len);    
            }    
            arrays[i] = arr;    
        }    
        return arrays;    
    }  
    
    
    public static RSAPrivateKey loadPrivateKey(InputStream in) throws Exception{
        try {
            BufferedReader br= new BufferedReader(new InputStreamReader(in));
            String readLine= null;
            StringBuilder sb= new StringBuilder();
            while((readLine= br.readLine())!=null){
                if(readLine.charAt(0)=='-'){
                    continue;
                }else{
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            return loadPrivateKey(sb.toString());
        } catch (IOException e) {
            throw new Exception("˽Կ���ݶ�ȡ����");
        } catch (NullPointerException e) {
            throw new Exception("˽Կ������Ϊ��");
        }
    }
    public static RSAPrivateKey loadPrivateKey(String privateKeyStr) throws Exception{
        try {
            BASE64Decoder base64Decoder= new BASE64Decoder();
            byte[] buffer= base64Decoder.decodeBuffer(privateKeyStr);
            PKCS8EncodedKeySpec keySpec= new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory= KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("�޴��㷨");
        } catch (InvalidKeySpecException e) {
            throw new Exception("˽Կ�Ƿ�");
        } catch (IOException e) {
            throw new Exception("˽Կ�������ݶ�ȡ����");
        } catch (NullPointerException e) {
            throw new Exception("˽Կ����Ϊ��");
        }
    }
    
    
    public static RSAPublicKey loadPublicKey(InputStream in) throws Exception{
        try {
            BufferedReader br= new BufferedReader(new InputStreamReader(in));
            String readLine= null;
            StringBuilder sb= new StringBuilder();
            while((readLine= br.readLine())!=null){
                if(readLine.charAt(0)=='-'){
                    continue;
                }else{
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            return loadPublicKey(sb.toString());
        } catch (IOException e) {
            throw new Exception("��Կ��������ȡ����");
        } catch (NullPointerException e) {
            throw new Exception("��Կ������Ϊ��");
        }
    }
    
    /**
     * ���ַ����м��ع�Կ
     * @param publicKeyStr ��Կ�����ַ���
     * @throws Exception ���ع�Կʱ�������쳣
     */
    public static RSAPublicKey loadPublicKey(String publicKeyStr) throws Exception{
        try {
            BASE64Decoder base64Decoder= new BASE64Decoder();
            byte[] buffer= base64Decoder.decodeBuffer(publicKeyStr);
            KeyFactory keyFactory= KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec= new X509EncodedKeySpec(buffer);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("�޴��㷨");
        } catch (InvalidKeySpecException e) {
            throw new Exception("��Կ�Ƿ�");
        } catch (IOException e) {
            throw new Exception("��Կ�������ݶ�ȡ����");
        } catch (NullPointerException e) {
            throw new Exception("��Կ����Ϊ��");
        }
    }
    /*
     * MD5����
     * */ 
    public static String MD5MsgDigestDemo(String pubDate){
    	MessageDigest md5Digest = null;
		try {
			md5Digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // ����Ҫ���������
        md5Digest.update(pubDate.getBytes());
        // ��ɹ�ϣ���㣬�õ�ժҪ
        byte[] md5Encoded = md5Digest.digest();
        System.out.println("ԭ��: " + pubDate);
        System.out.println("MD5ժҪ: " + byte2HexStr(md5Encoded));
        return byte2HexStr(md5Encoded);
    }
    
    /*
	 * ʵ���ֽ�������ʮ�����Ƶ�ת������һ
	 */
	public static String byte2HexStr(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}
    /*
     *���Է��� 
     */
    public static void main(String[] args) throws Exception {    
    	   
//        HashMap<String, Object> map = RsaUtils.getKeys();    
//        //���ɹ�Կ��˽Կ    
//        RSAPublicKey publicKey = (RSAPublicKey) map.get("public");    
//        RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");    
//            
//        //ģ    
//        String modulus = publicKey.getModulus().toString();    
//        //��Կָ��    
//        String public_exponent = publicKey.getPublicExponent().toString();    
//        //˽Կָ��    
//        String private_exponent = privateKey.getPrivateExponent().toString();    
        //����    
		JSONObject obj = new JSONObject();
		obj.put("logNo", "201804270298407869");
		obj.put("UserId", "");
		obj.put("BalDate", "20180427");
		obj.put("AgentId", "172");
		obj.put("TxnLogId", "9115248173556540156342038");
		obj.put("BusinessId", "800461000001090");
		obj.put("SDTermNo", "95126798");
		obj.put("TxnCode", "N001");
		obj.put("PayChannel", "2");
		obj.put("TxnDate", "20180427");
		obj.put("TxnTime", "162238");
		obj.put("TxnAmt", "43.9");
		obj.put("TxnStatus", "1");
		obj.put("BankType", "");
		obj.put("OfficeId", "91524817356294700943");
		obj.put("ChannelId", "9115248173556540156342038");
		obj.put("attach", "");
		obj.put("CrdFlg", "");
		
		String dataText = obj.toString();
		
        System.out.println("ԭ���ݣ�"+dataText);
        //ʹ��ģ��ָ�����ɹ�Կ��˽Կ    
     //   RSAPublicKey pubKey = RsaUtils.getPublicKey(modulus, public_exponent);    
     //   RSAPrivateKey priKey = RsaUtils.getPrivateKey(modulus, private_exponent); 
        /*
	     *��ȡ��Կ 
	     */
		File filepubkey = new File("C:/Users/hy133/Desktop/172_rsa_public_key.pem");
		FileInputStream finpubkey = new FileInputStream(filepubkey);
		RSAPublicKey pubKey =loadPublicKey(finpubkey);
		 /*
         * ��Կ����
         * */  
        String pubDate = encryptByPublicKey(dataText, pubKey);
        
        System.out.println("�������ݣ�"+pubDate);
        
        //�Լ������ݽ���MD5���� *�ǵ�ƴ��MD5��Կ*
        String MD5key = "e10adc3949ba59abbe56e057f20f883e";
        String MD5Data = pubDate + MD5key;//��ǩ����
        System.out.println("MD5��ǩԭ���ݣ�"+MD5Data);
        
        String signValue = MD5MsgDigestDemo(MD5Data);
        System.out.println("MD5��ǩ�����ݣ�"+signValue);
        
        //����������  ���ԡ���
//        JSONObject object = new JSONObject();
//        object.put("Datas", pubDate);
//        object.put("singValue", md5MsgDigestData);
//        
//        System.out.println(object.toString());
        /*
	     *��ȡ˽Կ
	     */
		File file = new File("C:/Users/hy133/Desktop/172_pkcs8_rsa_private_key.pem");
		FileInputStream fin = new FileInputStream(file);
        RSAPrivateKey priKey = loadPrivateKey(fin);
  
        /*
         * ˽Կ����
         * */  
        String priDate = decryptByPrivateKey(pubDate, priKey);   
  
        System.out.println("�������ݣ�"+priDate);
     
//        long time = System.currentTimeMillis();  
//        System.out.println(System.currentTimeMillis()-time); 
    }    
    
    
   
 
}