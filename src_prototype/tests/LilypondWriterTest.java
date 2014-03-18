package tests;

import static org.junit.Assert.*;


import java.io.IOException;

import main.Accord;

import org.junit.Test;

import writer.LilypondWriter;


import accords.*;

public class LilypondWriterTest {

	@Test
	public void test() throws IOException {
		Accord[] tab={new I(21,18,16,7,4),new IV(21,19,17,10,4),new VI(21,19,16,12,4),new V(22,20,18,11,4)};
		LilypondWriter writer=new LilypondWriter("test.ly",tab,"salutation");
		writer.ecrirePartition();
	}

}
