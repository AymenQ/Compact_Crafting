package moony.compactcrafting.core.handler;

import moony.compactcrafting.CCMain;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class CC_SoundHandler
{

	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		try
		{
			event.manager.soundPoolSounds.addSound("CC/PMOpen.ogg", CCMain.class
					.getResource("/moony/compactcrafting/sound/PMOpen.ogg"));
			event.manager.soundPoolSounds.addSound("CC/egg.ogg", CCMain.class
					.getResource("/moony/compactcrafting/sound/egg.ogg"));
		} catch (Exception e)
		{
			System.err.println("Failed to register one or more sounds");
		}
	}
}
