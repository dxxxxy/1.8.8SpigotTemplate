package studio.dreamys.exampleplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("ExamplePlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ExamplePlugin has been disabled!");
    }
}
