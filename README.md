KonumPlugin Eklentisi Dünya Haritası vb kullanıyorsanız bu eklenti config.ymlde örneğin türkiye bölgesinin kordinatlarını config.ymlde seçip ayarlıyorsunuz /konumadmin reload komutunu kullanarak o bölgeye gidip %konum_current_location% taba veya socreboarda ekliyorsunuz 
ve test ediyorsunuz artık oyuncunun olduğu kordinatlarda eğer configde bulunan bölgeler varsa o bölge an ve an placeholderda gösterir

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
