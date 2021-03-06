package com.jlkf.text.textapp.ui.home.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jlkf.text.textapp.R;
import com.jlkf.text.textapp.databinding.ActivityAudioPlayBinding;
import com.shuyu.gsyvideoplayer.GSYBaseActivityDetail;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;


/**
 * 功能：视频播放器
 * 依赖来源：https://github.com/CarGuo/GSYVideoPlayer
 * 本项目中添加该功能所对应的依赖：implementation 'com.shuyu:GSYVideoPlayer:6.0.1'
 */
public class AudioPlayActivity extends GSYBaseActivityDetail<StandardGSYVideoPlayer> {
    ActivityAudioPlayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_audio_play);
        //增加title
        binding.detailPlayer.getTitleTextView().setVisibility(View.GONE);
        binding.detailPlayer.getBackButton().setVisibility(View.VISIBLE);
        binding.detailPlayer.getBackButton().setOnClickListener(v -> finish());
        initVideoBuilderMode();
    }

    @Override
    public StandardGSYVideoPlayer getGSYVideoPlayer() {
        return binding.detailPlayer;
    }

    @Override
    public GSYVideoOptionBuilder getGSYVideoOptionBuilder() {
        ImageView imageView = new ImageView(this);
        loadCover(imageView, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1552632581841&di=f5b25f99ea67b12437774d0f70d8b0bd&imgtype=0&src=http%3A%2F%2Fwww.bainaben.com%2Fup_files%2Fimage%2FArticle%2F2009%2F02%2F03%2F32362951.jpg");
        return new GSYVideoOptionBuilder()
                .setThumbImageView(imageView)
                .setUrl("http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8")
                .setCacheWithPlay(true)
                .setVideoTitle(" ")
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setShowFullAnimation(false)
                .setNeedLockFull(true)
                .setSeekRatio(1);
    }

    @Override
    public void clickForFullScreen() {

    }

    @Override
    public boolean getDetailOrientationRotateAuto() {
        return true;
    }

    private void loadCover(ImageView imageView, String url) {
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.mipmap.ic_launcher);
        Glide.with(this.getApplicationContext())
                .setDefaultRequestOptions(
                        new RequestOptions()
                                .frame(3000000)
                                .centerCrop()
                                .error(R.mipmap.ic_launcher)
                                .placeholder(R.mipmap.ic_launcher))
                .load(url)
                .into(imageView);
    }
}
