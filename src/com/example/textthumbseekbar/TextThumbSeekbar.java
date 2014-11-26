package com.example.textthumbseekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
/**
 * Thumb带文字的SeekBar控件，适用于 00:00 的文字格式，超过这个长度效果不好。
 * @author chiemy
 *
 */
public class TextThumbSeekbar extends SeekBar {
	private int thumbTextColor = Color.WHITE;
	private String thumbText = "00:00";
	private Paint paint;
	private Drawable thumbDrawable;
	private int textSize;
	private int thumbWidth;

	public TextThumbSeekbar(Context context) {
		super(context);
		init();
	}

	public TextThumbSeekbar(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public TextThumbSeekbar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	@Override
	public void setThumb(Drawable thumb) {
		super.setThumb(thumb);
		thumbDrawable = thumb;
		thumbWidth = thumb.getIntrinsicWidth();
		textSize = thumbWidth / 5 * 2;
	}

	private void init() {
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setTextSize(textSize);
		paint.setColor(thumbTextColor);
		paint.setTextAlign(Paint.Align.CENTER);
	}
	

	@Override
	protected synchronized void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Rect rect = thumbDrawable.getBounds();
		float thumb_x = rect.left + thumbWidth / 2;
		canvas.drawText(thumbText, thumb_x, getTextY(), paint);
	}
	/**
	 * 获取文字中心位置
	 * @return
	 */
	private float getTextY() {
		FontMetrics fontMetrics = paint.getFontMetrics();  
		float fontTotalHeight = fontMetrics.bottom - fontMetrics.top;  
		float offY = fontTotalHeight / 2 - fontMetrics.bottom;  
		float newY = this.getHeight() / 2  + offY;  
		return newY;
	}

	/**
	 * 更新进度及Thumb上的文字
	 * @param progress
	 * @param text  Thumb上的文字
	 */
	public synchronized void setProgress(int progress, String text) {
		super.setProgress(progress);
		thumbText = text;
		invalidate();
	}

	/**
	 * 更新Thumb上的文字
	 * @param text
	 */
	public void setThumbText(String text) {
		thumbText = text;
		invalidate();
	}

}
