package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV
{
	private Speaker speaker;
	private int price;
	
	public SamsungTV()
	{
		System.out.println("---> SamsungTV(1) 객체생성.");
	}
	public SamsungTV(Speaker speaker)
	{
		System.out.println("---> SamsungTV(2) 객체생성.");
		this.speaker=speaker;
	}
	public SamsungTV(Speaker speaker, int price)
	{
		System.out.println("---> SamsungTV(3) 객체생성.");
		this.speaker = speaker;
		this.price = price;
	}
	public void setSpeaker(Speaker speaker)
	{
		System.out.println("--> setSpeaker() 호출.");
		this.speaker = speaker;
	}
	public void setPrice(int price)
	{
		System.out.println("--> setPrice() 호출.");
		this.price = price;
	}
	public void initMethod()
	{
		System.out.println("SamsungTV 객체초기화 처리. 가격: "+price);
	}
	public void destoryMethod()
	{
		System.out.println("SamsungTV 객체삭제 전 처리.");
	}
	public void powerOn()
	{
		System.out.println("SamsungTV---전원을 켠다.");
	}
	public void powerOff()
	{
		System.out.println("SamsungTV---전원을 끈다.");
	}
	public void volumeUp()
	{
		speaker.volumeUp();
		//System.out.println("SamsungTV---소리를 올린다.");
	}
	public void volumeDown()
	{
		speaker.volumeDown();
		//System.out.println("SamsungTV---소리를 내린다.");
	}
}
