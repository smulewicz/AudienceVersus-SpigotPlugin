package pro.smulewicz.audienceversus;

import java.net.InetSocketAddress;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class SpigotPlugin extends JavaPlugin implements Listener {
	public void onEnable() {
		System.out.print("Plugin enabled.");
		new MyTask().runTaskTimer(this, 0, 20);
	}

	public void onDisable() {
		System.out.print("Plugin disabled."); 
	}

    public class MyTask extends BukkitRunnable {
        public MyTask() {
            
        }

        @Override
        public void run() {
			try {
				WSServer server = new WSServer(new InetSocketAddress("192.168.1.164", 8081));
				server.run();
			}
			catch(Exception e) {
				System.out.print(e); 
			}
			this.cancel();
        }
    }
}
