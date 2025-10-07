package com.namelessrpg.codex.data;

import java.util.List;
import com.namelessrpg.codex.data.WeaponData;
import com.namelessrpg.codex.data.PotionData;

public class ItemCodex {
    private List<WeaponData> weapons;
    private List<PotionData> potions;

    // Constructor
    public ItemCodex() {}
    
    // Getter Functions
    public List<WeaponData> getWeapons() {
        return this.weapons;
    }
    public List<PotionData> getPotions() {
        return this.potions;
    }
}