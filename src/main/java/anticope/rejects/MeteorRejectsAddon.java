package anticope.rejects;

import anticope.rejects.commands.*;
import anticope.rejects.modules.*;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.gui.GuiThemes;
import meteordevelopment.meteorclient.systems.Systems;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeteorRejectsAddon extends MeteorAddon {
    public static final Logger LOG = LoggerFactory.getLogger("Rejects");
    public static final Category CATEGORY = new Category("Rejects", Items.BARRIER.getDefaultStack());
    public static final HudGroup HUD_GROUP = new HudGroup("Rejects");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Meteor Rejects Addon");

        // Modules
        Modules modules = Modules.get();

        modules.add(new OreSim());

        // Commands
        Commands.add(new SeedCommand());
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getWebsite() {
        return "https://github.com/AntiCope/meteor-rejects";
    }

    @Override
    public GithubRepo getRepo() {
        return new GithubRepo("AntiCope", "meteor-rejects");
    }

    @Override
    public String getCommit() {
        String commit = FabricLoader
                .getInstance()
                .getModContainer("meteor-rejects")
                .get().getMetadata()
                .getCustomValue("github:sha")
                .getAsString();
        LOG.info("Rejects version: {}", commit);
        return commit.isEmpty() ? null : commit.trim();
    }

    public String getPackage() {
        return "anticope.rejects";
    }
}
