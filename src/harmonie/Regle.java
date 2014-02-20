package harmonie;

public class Regle {
	/*
	 * Remarque: tierce=tonic+2    quinte=tonic+4=tierce+2
	 */

	public boolean regle2(int[] note) {
		if (note[6] < note[4] && note[4] < note[2] && note[2] < note[0]) {
			return true;
		}
		return false;
	}

	public boolean regle1(int[] note) {
		if (13 < note[0] && note[0] < 27 && 10 < note[2] && note[2] < 23
				&& 6 < note[4] && 2 < note[6] && note[6] < 16) {
			return true;
		}
		return false;
	}

	public boolean regle6(int[] noteC, int[] noteP) {
		for (int i = 0; i < 7; i++) {
			if (i % 2 == 0) {
				if ((noteP[i] - noteC[i]) < 7 && (noteC[i] - noteP[i]) < 7) {// interval
																				// de
																				// 6
																				// max
																				// entre
																				// les
																				// notes
					if (apartient(i, noteC, noteP)) {// dans le cas ou la note
														// est presente dans les
														// deux accords
						if (noteC[i] % 7 != noteP[i] % 7) {
							return false;
						}
					}
					if ((noteP[i] - noteC[i]) < 3 && (noteC[i] - noteP[i]) < 3) {// si
																					// la
																					// difference
																					// est
																					// >2
																					// elle
																					// doivent
																					// être
																					// de
																					// même
																					// nature
						if (nature(noteP[i], accord(noteP)) != nature(noteC[i],
								accord(noteC))) {
							return false;
						}
					}
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean regle3(int[] note, int[] ac) {
		if ((note[6] % 7) == (ac[0] % 7)) {
			if ((note[0] % 7) == (ac[1] % 7) || (note[2] % 7) == (ac[1] % 7)
					|| (note[4] % 7) == (ac[1] % 7)) {
				if ((note[0] % 7) == (ac[4] % 7)
						|| (note[2] % 7) == (ac[3] % 7)
						|| (note[4] % 7) == (ac[2] % 7)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean regle4(int[] partition) {
		int[] ac = Encoder.decode(partition[0]);
		int[] acf = Encoder.decode(partition[partition.length - 1]);
		if (ac[8] != 4 || acf[8] != 4) {
			return true;
		}
		return false;
	}

	public boolean regle5(int AcC, int AcS) {
		switch (AcC) {
		case (0):
			if (AcS != 4) {
				return true;
			}
		case (1):
			if (AcS == 5 || AcS == 7) {
				return true;
			}
		case (2):
			if (AcS != 0 && AcS != 4) {
				return true;
			}
		case (3):
			if (AcS != 4) {
				return true;
			}
		case (4):
			if (AcS == 1) {
				return true;
			}
		case (5):
			if (AcS == 0 || AcS == 2 || AcS == 4 || AcS == 6) {
				return true;
			}
		case (6):
			if (AcS == 0 || AcS == 2 || AcS == 3 || AcS == 5) {
				return true;
			}
		case (7):
			if (AcS == 0 || AcS == 2) {
				return true;
			}
		}
		return false;
	}

	public boolean apartient(int i, int[] note, int[] ac) {// verifie si la note
															// est presente dans
															// l'accord
		int n = note[i];
		for (int j = 0; j < ac.length - 1; j++) {
			if ((n % 7) == (ac[j] % 7)) {
				return true;
			}
		}
		return false;
	}

	public int accord(int[] note) {// retourne le numero de l'accord (ne fais
									// pas la difference entre le IV et le IVb
		switch (note[0] % 7) {
		case (0):
			return 0;
		case (1):
			return 1;
		case (2):
			return 2;
		case (3):
			return 3;
		case (4):
			return 5;
		case (5):
			return 6;
		case (6):
			return 7;
		}
		return -1;
	}

	public int nature(int note, int Ac) {// retourne la nature de la note
											// 1=tonic 2=tierce 3=quinte
		switch (Ac) {
		case (0):
			if ((note % 7) == 0) {
				return 1;
			} else {
				if ((note % 7) == 2) {
					return 2;
				}
			}
			return 3;
		case (1):
			if ((note % 7) == 1) {
				return 1;
			} else {
				if ((note % 7) == 3) {
					return 2;
				}
			}
			return 3;
		case (2):
			if ((note % 7) == 2) {
				return 1;
			} else {
				if ((note % 7) == 4) {
					return 2;
				}
			}
			return 3;
		case (3):
			if ((note % 7) == 3) {
				return 1;
			} else {
				if ((note % 7) == 5) {
					return 2;
				}
			}
			return 3;
		case (5):
			if ((note % 7) == 4) {
				return 1;
			} else {
				if ((note % 7) == 6) {
					return 2;
				}
			}
			return 3;
		case (6):
			if ((note % 7) == 5) {
				return 1;
			} else {
				if ((note % 7) == 0) {
					return 2;
				}
			}
			return 3;
		case (7):
			if ((note % 7) == 6) {
				return 1;
			} else {
				if ((note % 7) == 1) {
					return 2;
				}
			}
			return 3;
		}
		return -1;
	}
}