# spring-map
ตัวอย่างการใช้ Spring MVC, Hibernate, jQuery, Angular, Google Maps

![](https://raw.githubusercontent.com/codestar-work/spring-map/master/screen.png)

Project นี้จะมีฐานข้อมูลเป็นปั้มน้ำมัน Caltex ในออสเตรเลีย มีที่อยู่และ
Latitude, Longitude มาให้ครบ
- ฐานข้อมูลอยู่ที่ schema.sql
- อ่านข้อมูลผ่าน Hibernate
- มีตัวอย่างให้แค่ @Controller
- ถ้าต้องการส่งข้อมูลออกมา อย่าลืมใช้ @ResponseBody
- จะเพิ่ม @RestController ก็ได้ตามถนัด

# ตัวอย่างการเขียน Controller
- ตัวอย่างแรกเป็นการค้นหาปั้มน้ำมันตามรัฐ เช่น /state?name=tas จะแสดงปั้มน้ำมันในรัฐ
Tasmania ทั้งหมดออกมา
ในออสเตรเลียมีรัฐคือ ACT, NSW, NT, QLD, SA, TAS, VIC, WA

- ตัวอย่างที่สองเป็นการค้นหาโดยใช้กรอบสี่เหลี่ยม ในไฟล์ index.html จะส่ง request
มาโดยมีกรอบมาด้วย ในตัวอย่างนี้ยังไม่สมบูรณ์นั่นคือมันจะส่งปั้มน้ำมันทั้งหมดกลับไปให้
แทนที่จะส่งเพียงแค่อยู่ในกรอบ อย่าลืมเขียนเงื่อนไขเพื่อให้มันทำงานตามที่ต้องการ

# แบบฝึกหัดเพิ่มเติม
1. ให้สร้าง URL ชื่อ "/search-all?data=..." ค้นหาสถานีจากส่วนหนึ่งของ
suburb, address, postcode ส่งค่าออกมาเป็น JSON

2. ให้เขียน function search() ใน index.html ให้สมบูรณ์ ตอนนี้มันสามารถอ่านข้อมูลมาจาก
"/search-all" ได้แล้ว ต้องแสดงผลให้ผู้ใช้กดไปหา function goto() เพื่อ pan
ไปที่ตำแหน่งบนแผนที่ได้
