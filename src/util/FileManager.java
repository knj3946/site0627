package util;
//���ϰ� ���õ� ���� ���⿡ ����� ���� Ŭ����!!!

public class FileManager {
	//Ȯ���� ���ϱ�
	public static String getExt(String path) {
		int index=path.lastIndexOf(".");
		
		return path.substring(index+1,path.length());//Ȯ���� ��ȯ
	}
/*	public static void main(String[] args) {
		System.out.println(getExt("sfsfdsafasf.png"));
	}*/
}