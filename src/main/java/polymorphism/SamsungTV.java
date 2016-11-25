package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV
{
	private Speaker speaker;
	private int price;
	
	public SamsungTV()
	{
		System.out.println("---> SamsungTV(1) ��ü����.");
	}
	public SamsungTV(Speaker speaker)
	{
		System.out.println("---> SamsungTV(2) ��ü����.");
		this.speaker=speaker;
	}
	public SamsungTV(Speaker speaker, int price)
	{
		System.out.println("---> SamsungTV(3) ��ü����.");
		this.speaker = speaker;
		this.price = price;
	}
	public void setSpeaker(Speaker speaker)
	{
		System.out.println("--> setSpeaker() ȣ��.");
		this.speaker = speaker;
	}
	public void setPrice(int price)
	{
		System.out.println("--> setPrice() ȣ��.");
		this.price = price;
	}
	public void initMethod()
	{
		System.out.println("SamsungTV ��ü�ʱ�ȭ ó��. ����: "+price);
	}
	public void destoryMethod()
	{
		System.out.println("SamsungTV ��ü���� �� ó��.");
	}
	public void powerOn()
	{
		System.out.println("SamsungTV---������ �Ҵ�.");
	}
	public void powerOff()
	{
		System.out.println("SamsungTV---������ ����.");
	}
	public void volumeUp()
	{
		speaker.volumeUp();
		//System.out.println("SamsungTV---�Ҹ��� �ø���.");
	}
	public void volumeDown()
	{
		speaker.volumeDown();
		//System.out.println("SamsungTV---�Ҹ��� ������.");
	}
}
