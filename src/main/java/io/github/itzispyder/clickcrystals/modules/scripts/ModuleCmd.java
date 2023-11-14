package io.github.itzispyder.clickcrystals.modules.scripts;

import io.github.itzispyder.clickcrystals.Global;
import io.github.itzispyder.clickcrystals.client.clickscript.ScriptArgs;
import io.github.itzispyder.clickcrystals.client.clickscript.ScriptCommand;
import io.github.itzispyder.clickcrystals.modules.modules.ScriptedModule;

import java.util.function.Consumer;

public class ModuleCmd extends ScriptCommand implements Global {

    private static ScriptedModule currentScriptModule;

    public static ScriptedModule getCurrentScriptModule() {
        return currentScriptModule;
    }

    public static void runOnCurrentScriptModule(Consumer<ScriptedModule> action) {
        if (currentScriptModule != null) {
            action.accept(currentScriptModule);
        }
    }

    public ModuleCmd(){
        super("module");
    }

    @Override
    public void onCommand(ScriptCommand command, String line, ScriptArgs args) {
        switch (args.get(0).enumValue(Action.class, null)) {
            case CREATE -> {
                currentScriptModule = new ScriptedModule(args.get(1).stringValue(), "");
                system.addModule(currentScriptModule);
            }
            case ENABLE -> system.runModuleById(args.get(1).stringValue(), m -> m.setEnabled(true, true));
            case DISABLE -> system.runModuleById(args.get(1).stringValue(), m -> m.setEnabled(false, true));
        }

        if (args.match(2, "then")) {
            args.executeAll(3);
        }
    }

    public enum Action {
        CREATE,
        ENABLE,
        DISABLE
    }
}
