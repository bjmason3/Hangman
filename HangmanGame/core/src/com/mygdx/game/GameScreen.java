package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class GameScreen extends Screen {

	// originX & Y here are used to position the gallows
	private float originX = 100;
	private float originY = 175;
	
	private Table mainTable;
	private Table gallows;
	private Table chosen; 
	private Table input;
	private Table blanks;
	
	private SpriteBatch batch;	
	private Texture gallows_Stage;
	private Sprite stage_Sprite;
	private Texture gallows_Post;
	private Sprite post_Sprite;
	private Texture gallows_Arm;
	private Sprite arm_Sprite;
	private Texture gallows_Noose;
	private Sprite noose_Sprite;
	
	private Sprite[] bodyParts;
	private Texture head;
	private Sprite head_Sprite;
	private Texture body;
	private Sprite body_Sprite;
	private Texture lArm;
	private Sprite lArm_Sprite;
	private Texture rArm;
	private Sprite rArm_Sprite;
	private Texture lLeg;
	private Sprite lLeg_Sprite;
	private Texture rLeg;
	private Sprite rLeg_Sprite;
	
	GameScreen(MyGdxGame game_) {
		super(game_);
		
		// Here are the tables that may or may not be used for organization
		mainTable = new Table();
		gallows = new Table();
		chosen = new Table();
		input = new Table();
		blanks = new Table();
		
		// Create bodyParts array
		createBodyPartsArray();
		
		// Here are the textures and sprites for the gallows parts
		gallows_Stage = new Texture(Gdx.files.internal("HangmanPieces/Hangman_0001s_0003_Stage.png"));
		stage_Sprite = new Sprite(gallows_Stage);
		gallows_Post = new Texture(Gdx.files.internal("HangmanPieces/Hangman_0001s_0002_Post.png"));
		post_Sprite = new Sprite(gallows_Post);
		gallows_Arm = new Texture(Gdx.files.internal("HangmanPieces/Hangman_0001s_0001_Arm.png"));
		arm_Sprite = new Sprite(gallows_Arm);
		gallows_Noose = new Texture(Gdx.files.internal("HangmanPieces/Hangman_0001s_0000_Noose.png"));
		noose_Sprite = new Sprite(gallows_Noose);
		batch = new SpriteBatch();
		
		// adding the mainTable to the stage
		stage.addActor(mainTable);
		mainTable.setFillParent(true);
		
		// initializing the gallows and organizing on the "Stage"
		gallows.setFillParent(false);		
		mainTable.add(gallows).top().left();
	}
	
		/** drawGallows is used to position the gallows on the screen absolutely
		 * @param originX 
		 * @param originY
		 * 		originX & Y are used as the origin points to draw the gallows
		 * 			where 0,0 is the bottom left corner of the screen
		 * **/
	public void drawGallows() {
		// All logic for organizing and drawing gallows
		batch.draw(stage_Sprite, originX, originY, 192, 58);
		batch.draw(post_Sprite, originX+150, originY+58, 10, 228);
		batch.draw(arm_Sprite, (originX+150)-80, (originY+58+228)-55, 88, 55);
		batch.draw(noose_Sprite, (originX+150)-100, ((originY+58+228)-55)-30, 46, 77);
	}
	
	/**
	 * This method will load all textures and create all Sprites, then 
	 * @return the @param bodyParts which is a Sprite[]
	 */
	private Sprite[] createBodyPartsArray() {
		bodyParts = new Sprite[6];
		head = new Texture(Gdx.files.internal("HangmanPieces/Hangman_0000s_0004_Head.png"));
		head_Sprite = new Sprite(head);
		head_Sprite.setOrigin(50, 50);
		// head_Sprite.setPosition(x,y);
		// head_Sprite position here
		bodyParts[0] = head_Sprite;
		body = new Texture(Gdx.files.internal("HangmanPieces/Hangman_0000s_0005_Body.png"));
		body_Sprite = new Sprite(body);
		// body_Sprite position here
		bodyParts[1] = body_Sprite;
		lArm = new Texture(Gdx.files.internal("HangmanPieces/Hangman_0000s_0001_LeftArm.png"));
		lArm_Sprite = new Sprite(lArm);
		// lArm_Sprite position here
		bodyParts[2] = lArm_Sprite;
		rArm = new Texture(Gdx.files.internal("HangmanPieces/Hangman_0000s_0000_RightArm.png"));
		rArm_Sprite = new Sprite(rArm);
		// rArm_Sprite position here
		bodyParts[3] = rArm_Sprite;
		lLeg = new Texture(Gdx.files.internal("HangmanPieces/Hangman_0000s_0003_LeftLeg.png"));
		lLeg_Sprite = new Sprite(lLeg);
		// lLeg_Sprite position here
		bodyParts[4] = lLeg_Sprite;
		rLeg = new Texture(Gdx.files.internal("HangmanPieces/Hangman_0000s_0002_RightLeg.png"));
		rLeg_Sprite = new Sprite(rLeg);
		// rLeg_Sprite position here
		bodyParts[5] = rLeg_Sprite;		
		
		return bodyParts;
	}
	
	private void drawBodyParts(int wrongGuessNum) {
		/**
		// logic for drawing body parts goes here
		// Body parts have to have origin set before this method will work correctly
		for (int i = 0; i < wrongGuessNum; i++) {
			// 
			batch.draw(bodyParts[i], bodyParts[i].getOriginX(), bodyParts[i].getOriginY());
		}
		**/
		
		// tester method
		batch.draw(bodyParts[0], bodyParts[0].getOriginX(), bodyParts[0].getOriginY());
	}
	
	public void render() {
		super.render();	
		batch.begin();
		drawGallows();
		drawBodyParts(1);
		batch.end();
	}
	
	public void dispose() {
		super.dispose();
	}
	
	
}
