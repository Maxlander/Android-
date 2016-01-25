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

/*游戏对象的工厂类*/
public class GameObjectFactory {
	//创建小型敌机的方法
	public GameObject createSmallPlane(Resources resources){
		return new SmallPlane(resources);
	}
	//创建中型敌机的方法
	public GameObject createMiddlePlane(Resources resources){
		return new MiddlePlane(resources);
	}
	//创建大型敌机的方法
	public GameObject createBigPlane(Resources resources){
		return new BigPlane(resources);
	}
	//创建BOSS敌机的方法
	public GameObject createBossPlane(Resources resources){
		return new BossPlane(resources);
	}
	//创建玩家飞机的方法
	public GameObject createMyPlane(Resources resources){
		return new MyPlane(resources);
	}
	//创建玩家子弹
	public GameObject createMyBullet(Resources resources){
		return new MyBullet(resources);
	}
	//创建玩家子弹
	public GameObject createMyBullet2(Resources resources){
		return new MyBullet2(resources);
	}
	//创建BOSS子弹
	public GameObject createBossBullet(Resources resources){
		return new BossBullet(resources);
	}
	//创建导弹物品
	public GameObject createMissileGoods(Resources resources){
		return new MissileGoods(resources);
	}
	//创建子弹物品
	public GameObject createBulletGoods(Resources resources){
		return new BulletGoods(resources);
	}
}
