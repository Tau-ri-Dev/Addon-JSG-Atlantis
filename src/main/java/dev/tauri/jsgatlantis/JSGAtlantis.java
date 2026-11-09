package dev.tauri.jsgatlantis;

import dev.tauri.jsgcore.JSGAddon;
import dev.tauri.jsgcore.JSGAddons;
import dev.tauri.jsgcore.LoggerWrapper;
import dev.tauri.jsgcore.common.registry.helper.RegistryHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Mod(JSGAtlantis.MOD_ID)
public class JSGAtlantis implements JSGAddon {
    public static final String MOD_ID = "jsg_atlantis";
    public static final String MOD_NAME = "JSG: Atlantis Addon";
    public static LoggerWrapper logger;

    public static String MOD_VERSION = "";
    public static final String MC_VERSION = "1.20.1";

    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(JSGAtlantis.MOD_ID);

    public JSGAtlantis(FMLJavaModLoadingContext context) {
        logger = new LoggerWrapper("[jsg atlantis] ", LoggerFactory.getLogger(MOD_NAME));

        ModList.get().getModContainerById(MOD_ID).ifPresentOrElse(container -> MOD_VERSION = MC_VERSION + "-" + container.getModInfo().getVersion().getQualifier(), () -> {
        });
        JSGAtlantis.logger.info("Loading {} version {}", JSGAtlantis.MOD_NAME, JSGAtlantis.MOD_VERSION);

        var eventBus = context.getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);

        JSGAddons.registerAddon(this);
    }

    @Override
    @NotNull
    public String getId() {
        return MOD_ID;
    }

    @Override
    @NotNull
    public Optional<LoggerWrapper> getLoggerWrapper() {
        return Optional.of(logger);
    }

    @Override
    public String @NotNull [] getWelcomeLogo() {
        return new String[]{
        };
    }

    @Override
    public void onJSGCoreLoad() {
    }
}
