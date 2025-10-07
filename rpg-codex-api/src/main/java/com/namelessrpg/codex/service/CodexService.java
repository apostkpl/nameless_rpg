package com.namelessrpg.codex.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.namelessrpg.codex.data.ItemCodex;
import com.namelessrpg.codex.data.WeaponData;
import com.namelessrpg.codex.data.PotionData;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class CodexService {
    private final ItemCodex itemCodex;

    // Spring's default Resource Loader
    public CodexService(ResourceLoader resourceLoader) {
        this.itemCodex = loadData(resourceLoader);
    }

    private ItemCodex loadData(ResourceLoader resourceLoader) {
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            // Use Spring's ResourceLoader to access and open items.json
            InputStream inputStream = resourceLoader.getResource("classpath:items.json").getInputStream();
            
            // ObjectMapper reads the stream and converts it directly into the ItemCodex object
            return mapper.readValue(inputStream, ItemCodex.class);
            
        } catch (Exception e) {
            System.err.println("FATAL: Could not load file [items.json]. Empty lists created. Error details: " + e.getMessage());
            // Return an ItemCodex with empty lists
            return new ItemCodex(); 
        }
    }

    // Getter functions
    public List<WeaponData> getWeapons() {
        return itemCodex.getWeapons(); // ItemCodex class getter
    }

    public List<PotionData> getPotions() {
        return itemCodex.getPotions(); // ItemCodex class getter
    }

}