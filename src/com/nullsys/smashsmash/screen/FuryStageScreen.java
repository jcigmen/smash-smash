package com.nullsys.smashsmash.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.noobs2d.tweenengine.utils.DynamicValue;
import com.nullsys.smashsmash.bonuseffect.HammerTime;

public class FuryStageScreen extends ArcadeStageScreen {

    private static final int TIME_LIMIT = 120;

    public FuryStageScreen(Game game) {
	super(game);
	elapsed = new DynamicValue(0, TIME_LIMIT, TIME_LIMIT * 1000, 0);
	new HammerTime(new Vector2(0, 0), TIME_LIMIT * 2).trigger();
	sorcererSpawnDelay = TIME_LIMIT * 2;
    }

    @Override
    public String[] getTimerValues() {
	float left = TIME_LIMIT - elapsed.value;
	String one = "0", two = "0", three = "0", four = "0";
	if (left >= TIME_LIMIT)
	    two = "2";
	else if (left >= 60 && left < 120) {
	    two = "1";
	    three = left - 60 >= 10 ? Float.toString(left - 60).charAt(0) + "" : "0";
	    four = left - 60 >= 10 ? Float.toString(left - 60).charAt(1) + "" : Float.toString(left - 60).charAt(0) + "";
	} else {
	    two = "0";
	    three = left >= 10 ? Float.toString(left).charAt(0) + "" : "0";
	    four = left >= 10 ? Float.toString(left).charAt(1) + "" : Float.toString(left).charAt(0) + "";
	}
	return new String[] { one, two, ":", three, four };
    }

    @Override
    public boolean keyUp(int keycode) {
	if (keycode == Keys.CONTROL_LEFT || keycode == Keys.MENU)
	    game.setScreen(new FuryStageScreen(game));
	return super.keyUp(keycode);
    }

    @Override
    protected void initAliens() {
	super.initAliens();
	setAliensHostile(false);
    }

    @Override
    protected void setSpawnRate() {
	spawnRate = aliens.length;
    }
}
