package edu.wm.cs.cs301.gui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Paint;


import androidx.annotation.Nullable;

public class MazePanel extends View implements P7PanelS23 {
    private Canvas canvas;
    private Bitmap bitmap;
    private Paint paint;

    public MazePanel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }
    /*
    public MazePanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        //myTestImage(canvas);
    }
    public MazePanel(Context context) {
        super(context, null);
        init();
    }
     */

    void myTestImage(Canvas c) {
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(0, 0, 300, 300, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawRect(50, 50, 450,450, paint);
        paint.setColor(Color.BLUE);
    }

    private void init() {
        //bitmap=Bitmap.createBitmap(400,400, Bitmap.Config.ARGB_8888);
        paint = new Paint();
        bitmap=Bitmap.createBitmap(400,400, Bitmap.Config.ARGB_8888);
        canvas=new Canvas(bitmap);
        //addBackground(0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //paint.setColor(Color.RED);
        //addFilledRectangle(50, 50, 100, 100);


        //bitmap=Bitmap.createBitmap(400,400, Bitmap.Config.ARGB_8888);
        //canvas = new Canvas();
        //addBackground(0);

        paint = new Paint(0);
        paint.setColor(Color.BLUE);

        float left = 0, top = 0; // basically (X1, Y1)

        float right = left + 400; // width (distance from X1 to X2)
        float bottom = top + 400; // height (distance from Y1 to Y2)



    }


    @Override
    public void commit() {

    }

    @Override
    public boolean isOperational() {
        return false;
    }

    @Override
    public void setColor(int argb) {
        paint.setColor(argb);
    }

    @Override
    public int getColor() {
        return paint.getColor();
    }

    @Override
    public void addBackground(float percentToExit) {
/*
		gc.setColor(ColorTheme.getColor(MazeColors.FRAME_OUTSIDE));
        gc.fillRect(0, 0, Constants.VIEW_WIDTH, Constants.VIEW_HEIGHT);
        gc.setColor(ColorTheme.getColor(MazeColors.FRAME_MIDDLE));
        gc.fillRect(10, 10, Constants.VIEW_WIDTH-20, Constants.VIEW_HEIGHT-20);
        gc.setColor(ColorTheme.getColor(MazeColors.FRAME_INSIDE));
        gc.fillRect(15, 15, Constants.VIEW_WIDTH-30, Constants.VIEW_HEIGHT-30);
 */
        //Top
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, 200, 200, paint);
        //Bottom
        paint.setColor(Color.GRAY);
        canvas.drawRect(0, 200, 200, 200, paint);
    }

    @Override
    public void addFilledRectangle(int x, int y, int width, int height) {
        //x, y, x+width, y+height
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(x,y,x+width,y+width, paint);
    }

    @Override
    public void addFilledPolygon(int[] xPoints, int[] yPoints, int nPoints) {

    }

    @Override
    public void addPolygon(int[] xPoints, int[] yPoints, int nPoints) {

    }

    @Override
    public void addLine(int startX, int startY, int endX, int endY) {

    }

    @Override
    public void addFilledOval(int x, int y, int width, int height) {

    }

    @Override
    public void addArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

    }

    @Override
    public void addMarker(float x, float y, String str) {

    }

    @Override
    public void setRenderingHint(P7RenderingHints hintKey, P7RenderingHints hintValue) {

    }
}
