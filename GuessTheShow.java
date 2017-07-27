import javax.swing.JOptionPane;

public class GuessTheShow
{
	public static void main(String[] args)
	{
		String[] answerPhrases = {"Rick and Morty", "Family Guy", "Bobs Burgers", "Night Shift", "Greys Anatomy"};
		String displayPhrase = "";
		String buildDisplay;
		String prompt;
		String play = "Can you guess this phrase?";
		String enterOne = "\nEnter a single letter:";
		String sorry = "Sorry - letter not in phrase";
		String correct = "Correct!";
		String userResponse;
		char guess;
		char letter;
		boolean found = false;
		int position = 0;
		String target;
		int x;
		int random = (int)(Math.random() * 100) % answerPhrases.length;
		target = answerPhrases[random];
		target = target.toLowerCase();
		
		
		final int LEN = target.length();
		x = 0;
		
		while( x < LEN)
		{
			if(target.charAt(x) == ' ')
				displayPhrase = displayPhrase + ' ';
			else
				displayPhrase = displayPhrase + "*";
			++x;
		}
		
		
		//GAME BEGINS
		prompt = play + enterOne;
		
		while(displayPhrase.indexOf("*") != -1)
		{
			userResponse = JOptionPane.showInputDialog(null, prompt + displayPhrase);
			
			guess = userResponse.charAt(0);
			guess = Character.toLowerCase(guess);
			found = false;
			
			for(position = 0; position < LEN; ++position)
			{
				letter = target.charAt(position);
				if(letter == guess)
				{
					displayPhrase = displayPhrase.substring(0,position) + guess + displayPhrase.substring(position + 1, LEN);
					found = true;
				}
			}
			if(!found)
			{
				prompt = sorry;
			}
			else
			{
				prompt = correct + enterOne;
			}
		}
		JOptionPane.showMessageDialog(null, "Congratulations!! \nThe phrase was: " + answerPhrases[random]);
		
	}
}