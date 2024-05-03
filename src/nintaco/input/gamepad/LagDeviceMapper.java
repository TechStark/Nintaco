package nintaco.input.gamepad;

import java.io.*;
import nintaco.*;
import nintaco.cartdb.*;
import nintaco.input.*;
import static nintaco.App.*;

public abstract class LagDeviceMapper extends DeviceMapper 
    implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  private static final int LAG_SCANLINE = 128;
          
  protected int buttons;
  
  private int buttonsBuffer;
  private boolean lagButtons;  
  private volatile PPU ppu;
  
  public LagDeviceMapper() {
    final Cart cart = getCart();
    if (cart != null && CartDB.isEnabled()) {
      lagButtons = cart.isLagButtons();
    }
  }
  
  @Override
  public void setMachine(final Machine machine) {
    if (machine == null) {
      ppu = null;
    } else {
      ppu = machine.getPPU();
    }
  }  
  
  @Override
  public void update(final int buttons) {
    if (lagButtons) {
      this.buttons = buttonsBuffer;
      this.buttonsBuffer = buttons;
    } else {
      this.buttons = buttons;
    }
  }  
  
  protected void updateButtons() {
    if (lagButtons) {
      final PPU p = ppu;
      if (p != null && p.getScanline() >= LAG_SCANLINE) {
        buttons = buttonsBuffer;
      }
    }
  }
}
