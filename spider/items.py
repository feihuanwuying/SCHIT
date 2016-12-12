# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

from scrapy import Item, Field


class ZhihuPeopleItem(Item):
    """֪���û�����
    Attributes:
        nickname �û���
        zhihu_id �û�id
        location λ��
        business ��ҵ
        gender �Ա�
        employment ��˾
        position ְλ
        education �������
        image_url ͷ��ͼƬurl
    """
    nickname = Field()
    zhihu_id = Field()
    location = Field()
    business = Field()
    gender = Field()
    employment = Field()
    position = Field()
    education = Field()
    agree_count = Field()
    thanks_count = Field()
    followee_count = Field()
    follower_count = Field()
    image_url = Field()


class ZhihuRelationItem(Item):
    """֪���û���ϵ
    Attributes:
        zhihu_id ֪��id
        user_list �û��б�
        user_type �û����ͣ�1��ע���� 2��˿��
    """
    zhihu_id = Field()
    user_list = Field()
    user_type = Field()