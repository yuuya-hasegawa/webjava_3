package jp.co.systena.tigerscave.BattleOfMonster.application.model.battle;

import java.util.ArrayList;
import jp.co.systena.tigerscave.BattleOfMonster.application.lib.BattleServise;
import jp.co.systena.tigerscave.BattleOfMonster.application.model.monster.Monster;

public class Battle {

  public static BattleServise play(BattleServise battleServise) {
    // 戻り値となるパラメータの初期化
    Monster monsterOne = battleServise.getMonsterOne();
    Monster monsterTwo = battleServise.getMonsterTwo();
    ArrayList<String> battleLog = battleServise.getBattleLog();
    if (battleLog.isEmpty()) {
      battleLog.add(0, monsterOne.getMonsterName() + " vs " + monsterTwo.getMonsterName());
      battleLog.add(0, "バトルスタート");
      battleServise.setBattleLog(battleLog);
      return battleServise;
    }
    // バトル開始
    if (monsterOne.getAgilityPoint() >= monsterTwo.getAgilityPoint()) {
      // monsterOneの方が早い場合
      battleLog.add(0, monsterOne.getMonsterName() + "の攻撃");
      if (monsterTwo.avoidance()) {
        battleLog.add(0, monsterTwo.getMonsterName() + "は回避した");
      } else {
        String[] attack = monsterOne.attack(battleServise.getAttackNumber());
        battleLog.add(0, monsterOne.getMonsterName() + "の" + attack[0]);
        monsterTwo.damege(Integer.parseInt(attack[1]));
        battleLog.add(0, monsterTwo.getMonsterName() + "は" + attack[1] + "のダメージ");
      }
      if (0 >= monsterTwo.getHitPoint()) {
        battleLog.add(0, monsterTwo.getMonsterName() + "は倒れた");
        battleServise.setBattleStatus(0);
        battleServise.setMonsterOne(monsterOne);
        battleServise.setMonsterTwo(monsterTwo);
        battleServise.setBattleLog(battleLog);
        return battleServise;
      }
      battleLog.add(0, monsterTwo.getMonsterName() + "の攻撃");
      if (monsterOne.avoidance()) {
        battleLog.add(0, monsterOne.getMonsterName() + "は回避した");
      } else {
        String[] attack = monsterTwo.cpuAttack();
        battleLog.add(0, monsterTwo.getMonsterName() + "の" + attack[0]);
        monsterOne.damege(Integer.parseInt(attack[1]));
        battleLog.add(0, monsterOne.getMonsterName() + "は" + attack[1] + "のダメージ");
      }
      if (0 >= monsterOne.getHitPoint()) {
        battleLog.add(0, monsterOne.getMonsterName() + "は倒れた");
        battleServise.setBattleStatus(0);
        battleServise.setMonsterOne(monsterOne);
        battleServise.setMonsterTwo(monsterTwo);
        battleServise.setBattleLog(battleLog);
        return battleServise;
      }
    } else {
      battleLog.add(0, monsterTwo.getMonsterName() + "の攻撃");
      if (monsterOne.avoidance()) {
        battleLog.add(0, monsterOne.getMonsterName() + "は回避した");
      } else {
        String[] attack = monsterTwo.cpuAttack();
        battleLog.add(0, monsterTwo.getMonsterName() + "の" + attack[0]);
        monsterOne.damege(Integer.parseInt(attack[1]));
        battleLog.add(0, monsterOne.getMonsterName() + "は" + attack[1] + "のダメージ");
      }
      if (0 >= monsterOne.getHitPoint()) {
        battleLog.add(0, monsterOne.getMonsterName() + "は倒れた");
        battleServise.setBattleStatus(0);
        battleServise.setMonsterOne(monsterOne);
        battleServise.setMonsterTwo(monsterTwo);
        battleServise.setBattleLog(battleLog);
        return battleServise;
      }
      battleLog.add(0, monsterOne.getMonsterName() + "の攻撃");
      if (monsterTwo.avoidance()) {
        battleLog.add(0, monsterTwo.getMonsterName() + "は回避した");
      } else {
        String[] attack = monsterOne.attack(battleServise.getAttackNumber());
        battleLog.add(0, monsterOne.getMonsterName() + "の" + attack[0]);
        monsterTwo.damege(Integer.parseInt(attack[1]));
        battleLog.add(0, monsterTwo.getMonsterName() + "は" + attack[1] + "のダメージ");
      }
      if (0 >= monsterTwo.getHitPoint()) {
        battleLog.add(0, monsterTwo.getMonsterName() + "は倒れた");
        battleServise.setBattleStatus(0);
        battleServise.setMonsterOne(monsterOne);
        battleServise.setMonsterTwo(monsterTwo);
        battleServise.setBattleLog(battleLog);
        return battleServise;
      }
    }
    battleServise.setMonsterOne(monsterOne);
    battleServise.setMonsterTwo(monsterTwo);
    battleServise.setBattleLog(battleLog);
    return battleServise;
  }
}
