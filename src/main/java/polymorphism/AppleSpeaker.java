package polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker
{
	public AppleSpeaker()
	{
		System.out.println("--->AppleSpeaker 按眉 积己.");
	}
	public void volumeUp()
	{
		System.out.println("AppleSpeaker 家府棵赴促.");
	}
	public void volumeDown()
	{
		System.out.println("AppleSpeaker 家府郴赴促.");
	}
}