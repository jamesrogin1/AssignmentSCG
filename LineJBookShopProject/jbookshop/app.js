const express = require('express');
const line = require('@line/bot-sdk');

const app = express();

const config = {
    channelAccessToken : 'SNXVegI+S1S8V47XFur7tBBDeZa9e4sgNfEKvkn9UkjMht7KXrAgvdl7CqRx7h1ql8yguN+Zevvx4vmDVLZ9K1EwZyMctiISSet4pvxHfqzRw8xHcGhsccf2JDuJpdIve88E5WK5Isczb0IgKHkKCAdB04t89/1O/w1cDnyilFU=',
    channelSecret : 'afafb8f344e90ba9c22ca89bce837499'
};

const client = new line.Client(config);

app.post('/webhook', line.middleware(config), (req, res) => {
    Promise
        .all(req.body.events.map(handleEvent))
        .then((result) => res.json(result));
});

function handleEvent(event) {

    console.log(event);
    if (event.type === 'message' && event.message.type === 'text') {
        handleMessageEvent(event);
    } else {
        return Promise.resolve(null);
    }
}

function handleMessageEvent(event) {
    var msg = {
        type: 'text',
        text: 'ยินดีต้อนรับครับ'
    };

    var eventText = event.message.text.toLowerCase();

    if (eventText === 'สถานะร้าน') {
        msg = {
            'type': 'text',
            'text': 'ร้านเปิด 9:00 - 22:00 น.'
        }
    } else if (eventText === 'สถานที่ร้าน') {
        msg = {
            "type": "location",
            "title": "location ร้าน",
            "address": "เดอะมอลล์บางกะปิ",
            "latitude": 13.7660558,
            "longitude": 100.6424919
        }
    } else if (eventText === 'ติดต่อเรา') {
        msg = {
            'type': 'text',
            'text': '3522 ถนนลาดพร้าว แขวง คลองจั่น เขตบางกะปิ \n กรุงเทพมหานคร 10240 \n line id : jamesrogin \n เบอร์โทรศัพท์ : 086-999-4653'
        }
    } else if (eventText === 'รายการหนังสือ') {
        msg = {
            "type": "template",
            "altText": "this is a carousel template",
            "template": {
                "type": "carousel",
                "columns": [
                    {
                        "thumbnailImageUrl": "https://www.amarinbooks.com/wp-content/uploads/2017/09/it1-01.png?strip=all&w=742&quality=100",
                        "title": "อิท (IT) เล่ม 1",
                        "text": "หมวดหมู่ : นิยายแปล \nผู้แต่ง : Stephen King",
                        "actions": [
                            {
                                "type": "postback",
                                "label": "ราคา : 495.00 บาท",
                                "data": "action=buy"
                            },
                            {
                                "type": "uri",
                                "label": "รายละเอียด",
                                "uri": "https://www.amarinbooks.com/product/%E0%B8%AD%E0%B8%B4%E0%B8%97-it-%E0%B9%80%E0%B8%A5%E0%B9%88%E0%B8%A1-1-2/"
                            }
                        ]
                    },
                    {
                        "thumbnailImageUrl": "https://www.amarinbooks.com/wp-content/uploads/2017/06/32.jpg?strip=all&w=742&quality=100",
                        "title": "เดอะไชนิ่ง คืนนรก",
                        "text": "หมวดหมู่ : นิยายแปล \nผู้แต่ง : Stephen King",
                        "actions": [
                            {
                                "type": "postback",
                                "label": "ราคา : 325.00 บาท",
                                "data": "action=buy"
                            },
                            {
                                "type": "uri",
                                "label": "รายละเอียด",
                                "uri": "https://www.amarinbooks.com/product/%e0%b9%80%e0%b8%94%e0%b8%ad%e0%b8%b0%e0%b9%84%e0%b8%8a%e0%b8%99%e0%b8%b4%e0%b9%88%e0%b8%87-%e0%b8%84%e0%b8%b7%e0%b8%99%e0%b8%99%e0%b8%a3%e0%b8%81/"
                            }
                        ]
                    },
                    {
                        "thumbnailImageUrl": "https://www.amarinbooks.com/wp-content/uploads/2018/06/misery-01.png?strip=all&w=742&quality=100",
                        "title": "คลั่ง ขัง ฆ่า (MISERY)",
                        "text": "หมวดหมู่ : นิยายแปล \nผู้แต่ง : Stephen King",
                        "actions": [
                            {
                                "type": "postback",
                                "label": "ราคา : 335.00 บาท",
                                "data": "action=buy"
                            },
                            {
                                "type": "uri",
                                "label": "รายละเอียด",
                                "uri": "https://www.amarinbooks.com/product/%e0%b8%84%e0%b8%a5%e0%b8%b1%e0%b9%88%e0%b8%87-%e0%b8%82%e0%b8%b1%e0%b8%87-%e0%b8%86%e0%b9%88%e0%b8%b2-misery/"
                            }
                        ]
                    },
                    {
                        "thumbnailImageUrl": "https://www.amarinbooks.com/wp-content/uploads/2019/03/petsemetary-01.png?strip=all&w=742&quality=100",
                        "title": "กลับจากป่าช้า (PET SEMATARY)",
                        "text": "หมวดหมู่ : นิยายแปล \nผู้แต่ง : Stephen King",
                        "actions": [
                            {
                                "type": "postback",
                                "label": "ราคา : 435.00 บาท",
                                "data": "action=buy"
                            },
                            {
                                "type": "uri",
                                "label": "รายละเอียด",
                                "uri": "https://www.amarinbooks.com/product/%e0%b8%81%e0%b8%a5%e0%b8%b1%e0%b8%9a%e0%b8%88%e0%b8%b2%e0%b8%81%e0%b8%9b%e0%b9%88%e0%b8%b2%e0%b8%8a%e0%b9%89%e0%b8%b2-pet-sematary/"
                            }
                        ]
                    }
                ]
            }
        }
    }

    return client.replyMessage(event.replyToken, msg);
}

app.set('port', (process.env.PORT || 4000));

app.listen(app.get('port'), function () {
    console.log('run at port', app.get('port'));
});