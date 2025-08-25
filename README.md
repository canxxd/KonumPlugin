**KonumPlugin**, Minecraft sunucularınızda özel bölgeler (regions) tanımlamanıza ve oyuncuların hangi bölgede olduğunu **anlık olarak takip etmenize** olanak tanıyan bir Bukkit/Spigot eklentisidir.  

## ✨ Özellikler
- `config.yml` üzerinden istediğiniz bölgeleri tanımlayabilirsiniz.  
- Bölge sınırlarını **iki köşe noktası** (pos1, pos2) ile belirleyebilirsiniz.  
- Oyuncuların bulunduğu bölgeyi **PlaceholderAPI** desteğiyle gösterebilirsiniz.  
- `/konumadmin reload` komutuyla config’i yeniden yükleyebilirsiniz.  
- Tablist, scoreboard veya chat mesajlarında bölge adını gösterebilirsiniz.  

## ⚙️ Kurulum
1. `KonumPlugin.jar` dosyasını `plugins/` klasörüne atın.  
2. Sunucuyu başlatın.  
3. `config.yml` içinde örnek bir bölge tanımlayın:  

 örnek config.yml
 - 
  - Türkiye:
    - world: world #dünyanın adı örnek dünya mapi hangi dünyada ise onun adını yaz
    - pos1: #pos 1 ve pos2 seçeceğiniz bölgenin bir diğer sol alt bölgesi diğeri ise tam çapraz pos2 bölgesidir
      - x: -500
      - y: 60
      - z: -500
    - pos2:
      - x: -400
      - y: 80
      - z: -400
     
 - bundan istediğiniz kadar koyabilirsiniz ismi farklı olmak şekilinde
  
  - Almanya:
    - world: world
    - pos1:
      - x: 10
      - y: 30
      - z: 10
    - pos2:
      - x: 50
      - y: 70
      - z: 50
        
- placeholderapi: %konum_current_location%
