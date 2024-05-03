package nintaco.input.snesmouse;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class SnesMouseConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public SnesMouseConfig() {
    super(SnesMouse);
  }
  
  public SnesMouseConfig(final List<ButtonMapping> buttonMappings) {
    super(SnesMouse, buttonMappings);
  }
  
  public SnesMouseConfig(final SnesMouseConfig snesMouseConfig) {
    super(snesMouseConfig);
  }
  
  @Override
  public SnesMouseConfig copy() {
    return new SnesMouseConfig(this);
  }
}