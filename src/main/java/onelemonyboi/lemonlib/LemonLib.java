package onelemonyboi.lemonlib;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import onelemonyboi.lemonlib.rewards.PatreonRewards;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.neoforged.neoforge.common.NeoForge.EVENT_BUS;

@Mod(LemonLib.MOD_ID)
public class LemonLib {
    public static final String MOD_ID = "lemonlib";
    public static final Logger LOGGER = LogManager.getLogger();

    public LemonLib(IEventBus bus)
    {
        bus.addListener(this::setup);
        bus.addListener(this::doClientStuff);
        bus.addListener(this::enqueueIMC);
        bus.addListener(this::setup);
        EVENT_BUS.addListener(PatreonRewards::PatreonRewardsHandling);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        this.preInit(event);
        this.init(event);
        this.postInit(event);
    }
    private void doClientStuff(final FMLClientSetupEvent event) // Render Stuff HERE!!
    {
    }

    private void enqueueIMC(InterModEnqueueEvent event) {

    }

    private void preInit(FMLCommonSetupEvent event) {

    }

    private void init(FMLCommonSetupEvent event) {

    }

    private void postInit(FMLCommonSetupEvent event) {

    }

    public static Logger getLogger()
    {
        return LOGGER;
    }
}
