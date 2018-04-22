package panda.primitivetools;

import com.google.common.base.Predicate;
import javax.annotation.Nullable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public final class MaterialMultiplexer
  implements Predicate<IBlockState>
{
  private final Material[] materials;
  
  private MaterialMultiplexer(Material... materials)
  {
    this.materials = materials;
  }
  
  public static MaterialMultiplexer forMaterial(Material... materials)
  {
    return new MaterialMultiplexer(materials);
  }
  

  public boolean apply(@Nullable IBlockState state)
  {
    for (Material material : this.materials) {
      if ((state != null) && (state.getMaterial() == material))
        return true;
    }
    return false;
  }
}
