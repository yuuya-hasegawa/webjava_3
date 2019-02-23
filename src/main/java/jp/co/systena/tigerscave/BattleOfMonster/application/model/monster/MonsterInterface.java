package jp.co.systena.tigerscave.BattleOfMonster.application.model.monster;

public interface MonsterInterface {
  String[] attack(int attackPattern); //素ダメージ算出、戻り値：["技名", "素のダメージ値"]
  String[] cpuAttack(); //CPUのダメージ算出
  boolean avoidance(); //回避判定
  void damege(int damegePoint); //ダメージ反映
}