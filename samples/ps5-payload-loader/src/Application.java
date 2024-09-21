import org.homebrew.KernelMemory;
import org.homebrew.KernelPatching;
import org.homebrew.LoggingUI;
import org.homebrew.PrivilegeEscalation;

public class Application {

    public static void main(String args[]) {
        try {
	    LoggingUI.getInstance().log("[*] Disabling Java security manager...");
	    PrivilegeEscalation.disableSecurityManager();
	    LoggingUI.getInstance().log("[+] Java security manager disabled");

	    LoggingUI.getInstance().log("[*] Obtaining kernel .data R/W capabilities...");
	    KernelMemory.enableRW();
	    LoggingUI.getInstance().log("[+] Kernel .data R/W achieved");

	    KernelPatching.escalatePrivileges();
	    KernelPatching.setSceAuthId(0x4801000000000013l);
	    KernelPatching.setSceCaps(0xffffffffffffffffl, 0xffffffffffffffffl);
	    KernelPatching.setSceAttr(KernelPatching.getSceAttr() | 0x80);
	    LoggingUI.getInstance().log("[+] Escalated privileges");

	    KernelPatching.setSecurityFlags(KernelPatching.getSecurityFlags() | 0x14);
	    KernelPatching.setUtokenFlags((byte)(KernelPatching.getUtokenFlags() | 0x1));
	    KernelPatching.setQAFlags(KernelPatching.getQAFlags() | 0x0000000000010300l);
	    KernelPatching.setTargetId((byte)0x82);
	    LoggingUI.getInstance().log("[+] Debug/dev mode enabled");
	} catch (Throwable t) {
	    LoggingUI.getInstance().log(t);
	}
    }
}
