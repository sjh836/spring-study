package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV
{
	@Autowired
	@Qualifier("apple")
	private Speaker speaker;
	
	public LgTV()
	{
		System.out.println("---> LgTV() 객체생성.");
	}
	public void powerOn()
	{
		System.out.println("LgTV---전원을 켠다.");
	}
	public void powerOff()
	{
		System.out.println("LgTV---전원을 끈다.");
	}
	public void volumeUp()
	{
		speaker.volumeUp();
		//System.out.println("LgTV---소리를 올린다.");
	}
	public void volumeDown()
	{
		speaker.volumeDown();
		//System.out.println("LgTV---소리를 내린다.");
	}
}
