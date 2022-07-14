package net.identitytheft.sculkitems.entity.damage;

import net.minecraft.entity.damage.DamageSource;

public class ModDamageSource extends DamageSource{
    public static final DamageSource DRANK_BLEACH = new ModDamageSource("drank_bleach");
    public static final DamageSource DRANK_BLEACH_NO_HUNGER = new ModDamageSource("drank_bleach_no_hunger");

    protected ModDamageSource(String name) {
        super(name);
    }
}
