package xyz.itwill01.old;

public class HelloMessagePrint {
	public void helloMessagePrint() {
		HelloMessageObject object=new HelloMessageObject();
		String message=object.getHelloMessage();
		System.out.println("message = "+message);
	}
}
