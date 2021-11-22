package xyz.itwill02.factory;

//Factory 디자인 패턴이 적용된 클래스 - Factory 클래스 또는 Provider 클래스
// => 인스턴스(객체)를 생성하여 반환하는 기능을 제공하는 클래스
public class MessageObjectFactory {
	private static MessageObjectFactory _factory;
	
	//반환되는 객체 타입을 설정하기 위한 상수 선언
	public final static int HELLO_MESSAGE=1; 
	public final static int HI_MESSAGE=2; 
	
	private MessageObjectFactory() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_factory=new MessageObjectFactory();
	}
	
	public static MessageObjectFactory getFactory() {
		return _factory;
	}
	
	//정수값을 전달받아 비교하여 인터페이스를 상속받은 자식클래스로 인스턴스를 생성하여
	//반환하는 메소드
	public MessageObject getMessageObject(int messageObject) {
		MessageObject object=null;
		switch(messageObject) {
		case HELLO_MESSAGE: 
			object=new HelloMessageObject(); 
			break;
		case HI_MESSAGE: 
			object=new HiMessageObject();
			break;
		}
		return object;
	}
}









