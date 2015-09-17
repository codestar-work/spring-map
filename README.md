# spring-map
ตัวอย่างการใช้ Spring MVC, Hibernate, jQuery, Angular, Google Maps

![](https://raw.githubusercontent.com/codestar-work/spring-map/master/screen.png)

Project นี้จะมีฐานข้อมูลเป็นปั้มน้ำมันในออสเตรเลีย มีที่อยู่และ Latitude, Longitude มาให้ครบ
- ฐานข้อมูลอยู่ที่ schema.sql
- อ่านข้อมูลผ่าน Hibernate
- มีตัวอย่างให้แค่ @Controller
- ถ้าต้องการส่งข้อมูลออกมา อย่าลืมใช้ @ResponseBody 
- จะเพิ่ม @RestController ก็ได้ตามถนัด

# ตัวอย่างการเขียน Controller
- ตัวอย่างแรกเป็นการค้นหาปั้มน้ำมันตามรัฐ เช่น /state?name=tas จะแสดงปั้มน้ำมันในรัฐ 
Tasmania ทั้งหมดออกมา ในออสเตรเลียมีรัฐดังนี้ ACT, NSW, VIC, NT, WA, SA, TAS,

- ตัวอย่างที่สองเป็นการค้นหาโดยใช้กรอบสี่เหลี่ยม ในไฟล์ index.html จะส่ง request มาโดยมีกรอบมาด้วย
ในตัวอย่างนี้ยังไม่สมบูรณ์นั่นคือมันจะส่งปั้มน้ำมันทั้งหมดกลับไปให้แทนที่จะส่งเพียงแค่อยู่ในกรอบ 
หน้าที่ของคุณคือเขียนเงื่อนไขเพื่อให้มันทำงานตามที่ต้องการ
