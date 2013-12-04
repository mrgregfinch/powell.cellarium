// Date: 11/24/2013 10:27:26 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package powell.rasterland.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRasterBike extends ModelBase
{
  //fields
    ModelRenderer MainBody;
    ModelRenderer FrontOutter;
    ModelRenderer RearOutter;
    ModelRenderer RearInner;
    ModelRenderer FrontInner;
  
  public ModelRasterBike()
  {
    textureWidth = 256;
    textureHeight = 256;
    
      MainBody = new ModelRenderer(this, 0, 37);
      MainBody.addBox(-6F, -6F, -21F, 12, 12, 32);
      MainBody.setRotationPoint(0F, 11F, 0F);
      MainBody.setTextureSize(256, 256);
      MainBody.mirror = true;
      setRotation(MainBody, 0F, 0F, 0F);
      FrontOutter = new ModelRenderer(this, 0, 84);
      FrontOutter.addBox(-8F, -12F, -12F, 16, 24, 24);
      FrontOutter.setRotationPoint(0F, 12F, -33F);
      FrontOutter.setTextureSize(256, 256);
      FrontOutter.mirror = true;
      setRotation(FrontOutter, 0F, 0F, 0F);
      RearOutter = new ModelRenderer(this, 0, 84);
      RearOutter.addBox(-8F, -12F, -12F, 16, 24, 24);
      RearOutter.setRotationPoint(0F, 12F, 23F);
      RearOutter.setTextureSize(256, 256);
      RearOutter.mirror = true;
      setRotation(RearOutter, 0F, 0F, 0F);
      RearInner = new ModelRenderer(this, 0, 0);
      RearInner.addBox(-6F, -8.5F, -7.5F, 12, 17, 17);
      RearInner.setRotationPoint(0F, 12F, 22F);
      RearInner.setTextureSize(256, 256);
      RearInner.mirror = true;
      setRotation(RearInner, 0F, 0F, 0F);
      FrontInner = new ModelRenderer(this, 0, 0);
      FrontInner.addBox(-6F, -8.5F, -7.5F, 12, 17, 17);
      FrontInner.setRotationPoint(0F, 12F, -34F);
      FrontInner.setTextureSize(256, 256);
      FrontInner.mirror = true;
      setRotation(FrontInner, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    MainBody.render(f5);
    FrontOutter.render(f5);
    RearOutter.render(f5);
    RearInner.render(f5);
    FrontInner.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}