package com.kalu.Bot.lavaplayer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.MutableAudioFrame;

import net.dv8tion.jda.api.audio.AudioSendHandler;

public class AudioPlayerSendHandler implements AudioSendHandler{
	 private final AudioPlayer audioPlayer;
	 private final ByteBuffer buffer;
	 private final MutableAudioFrame frame;
	 
	 public AudioPlayerSendHandler(AudioPlayer audioplayer) {
		 this.audioPlayer = audioplayer;
		 this.buffer = ByteBuffer.allocate(2048);
		 this.frame = new MutableAudioFrame();
		 this.frame.setBuffer(buffer);
	}
	@Override
	public boolean canProvide() {
		return this.audioPlayer.provide(this.frame);
	}

	@Override
	public ByteBuffer provide20MsAudio() {
		final Buffer tmp = ((Buffer) this.buffer).flip();
		return (ByteBuffer) tmp;
	}
	 @Override
	public boolean isOpus() {
		return true;
	}

}
