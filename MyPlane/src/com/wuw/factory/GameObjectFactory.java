package com.wuw.factory;

import com.wuw.object.BigPlane;
import com.wuw.object.BossBullet;
import com.wuw.object.BossPlane;
import com.wuw.object.BulletGoods;
import com.wuw.object.GameObject;
import com.wuw.object.MiddlePlane;
import com.wuw.object.MissileGoods;
import com.wuw.object.MyBullet;
import com.wuw.object.MyBullet2;
import com.wuw.object.MyPlane;
import com.wuw.object.SmallPlane;

import android.content.res.Resources;

/*��Ϸ����Ĺ�����*/
public class GameObjectFactory {
	//����С�͵л��ķ���
	public GameObject createSmallPlane(Resources resources){
		return new SmallPlane(resources);
	}
	//�������͵л��ķ���
	public GameObject createMiddlePlane(Resources resources){
		return new MiddlePlane(resources);
	}
	//�������͵л��ķ���
	public GameObject createBigPlane(Resources resources){
		return new BigPlane(resources);
	}
	//����BOSS�л��ķ���
	public GameObject createBossPlane(Resources resources){
		return new BossPlane(resources);
	}
	//������ҷɻ��ķ���
	public GameObject createMyPlane(Resources resources){
		return new MyPlane(resources);
	}
	//��������ӵ�
	public GameObject createMyBullet(Resources resources){
		return new MyBullet(resources);
	}
	//��������ӵ�
	public GameObject createMyBullet2(Resources resources){
		return new MyBullet2(resources);
	}
	//����BOSS�ӵ�
	public GameObject createBossBullet(Resources resources){
		return new BossBullet(resources);
	}
	//����������Ʒ
	public GameObject createMissileGoods(Resources resources){
		return new MissileGoods(resources);
	}
	//�����ӵ���Ʒ
	public GameObject createBulletGoods(Resources resources){
		return new BulletGoods(resources);
	}
}
