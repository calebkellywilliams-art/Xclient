package com.example.xclient;

import com.example.xclient.Module.Category;
import net.minecraft.client.MinecraftClient;

import java.util.List;

public final class Modules {
    public static final Module ESP        = new Module("ESP", Category.RENDER);
    public static final Module XRAY       = new Module("X-Ray", Category.RENDER);
    public static final Module FULLBRIGHT = new Module("Fullbright", Category.RENDER);
    public static final Module REACH      = new Module("Reach", Category.COMBAT);
    public static final Module HUD        = new Module("HUD", Category.CLIENT);

    public static final Setting REACH_BLOCK  = new Setting("Block", 3.0, 8.0, 0.5, 6.0);   // vanilla 4.5
    public static final Setting REACH_ENTITY = new Setting("Entity", 3.0, 8.0, 0.5, 6.0);  // vanilla 3.0

    public static final List<Module> ALL = List.of(ESP, XRAY, FULLBRIGHT, REACH, HUD);

    static {
        HUD.enabled = true;
        REACH.settings.add(REACH_BLOCK);
        REACH.settings.add(REACH_ENTITY);
        XRAY.onChange = on -> {
            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc.worldRenderer != null) mc.worldRenderer.reload(); // rebuild chunk meshes
        };
    }

    private Modules() {}
}
