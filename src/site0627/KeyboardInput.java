package site0627;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyboardInput {

	public static void main(String[] args) {
		//모든 입력 스트림의 최상위 클래스이다!
		//따라서 그 어떤 도구나 입력기기를 사용한다 할지라도, 이 클래스
		//로 레퍼런스 할 수 있다.!!
		InputStream is=System.in;
		
		//InputStreamReader reader=new InputStreamReader(is);
		
		try {
			int data=0;
			
			data=is.read();
			System.out.print((char)data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
