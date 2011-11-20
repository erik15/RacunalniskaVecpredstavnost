package com.test.mojtrikotnik;

import java.io.IOException;

import android.media.MediaPlayer;

public class AddSound 
{
	MediaPlayer player = new MediaPlayer();
	
	public void SelectSound(String direktorij, String name_sound)
	{
        try 
        {
            player.setDataSource(direktorij + "/" + name_sound); //Iskanje datoteke
        } 
        catch (IllegalArgumentException e) 
        {
            e.printStackTrace();
        } 
        catch (IllegalStateException e) 
        {
            e.printStackTrace();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        try 
        {
            player.prepare();
        } 
        catch (IllegalStateException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
	
	public void Predvajaj()
	{
		player.start();
	}

	public void Stop()
	{
		player.stop();
	}

}
