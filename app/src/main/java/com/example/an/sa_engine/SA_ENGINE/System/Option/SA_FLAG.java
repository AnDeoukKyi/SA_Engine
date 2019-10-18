package com.example.an.sa_engine.SA_ENGINE.System.Option;

public class SA_FLAG {

    public static final int USER_VIEW_TYPE_PORTRAIT = 0x00000000;
    public static final int USER_VIEW_TYPE_LANDSCAPE = 0x00000001;

    public static final int USER_VIEW_WINDOWSIZE_YES = 0x00100000;
    public static final int USER_VIEW_WINDOWSIZE_NO = 0x00100001;




    public static final int USER_DEBUG_MODE_YES = 0x01000000;
    public static final int USER_DEBUG_MODE_NO = 0x01000001;

    public static final int USER_DEBUG_LOG_CREATEOBJ_YES = 0x01100000;
    public static final int USER_DEBUG_LOG_CREATEOBJ_NO = 0x01100001;



    public static final int ENGINE_DRAW_SPRITE_CREATE = 0x10000000;
    public static final int ENGINE_DRAW_RECT_CREATE = 0x10100000;
    public static final int ENGINE_DRAW_LINE_CREATE = 0x10200000;
    public static final int ENGINE_DRAW_TEXT_CREATE = 0x10300000;
    public static final int ENGINE_DRAW_OPTION_EDGE = 0x10400000;
    public static final int ENGINE_DRAW_OPTION_FILL = 0x10400001;


    public static final int ENGINE_MASK_CREATE_RECT = 0x11000000;
    public static final int ENGINE_MASK_CREATE_CIRCLE = 0x11000001;
    public static final int ENGINE_MASK_CREATE_AUTO = 0x11000002;
    public static final int ENGINE_MASK_CREATE_CUSTOM = 0x11000003;



    public static final int ENGINE_CLICK_DOWN = 0x12000000;
    public static final int ENGINE_CLICK_UP = 0x12000001;
    public static final int ENGINE_CLICK_DRAG = 0x12000002;


    public static final int ELSE_POS_NOTHING = 0x21000000;
    public static final int ELSE_POS_CENTER = 0x21000001;
}
