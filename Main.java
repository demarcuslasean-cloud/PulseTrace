import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
public class Main {
    static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a MIDI file");
            return;
        }
        File file = new File(args[0]);

        try {
            Sequence sequence = MidiSystem.getSequence(file);
            System.out.println("MIDI file loaded successfully");

            Track[] tracks = sequence.getTracks();
            System.out.println("Number of tracks: " + tracks.length);

            System.out.println("System Resolution: " + sequence.getResolution());

            System.out.println("Number of MIDI ticks: " + sequence.getTickLength());

            for (Track track : tracks) {
                System.out.println(track);
                int numOfEvents = track.size();
                for (int i = 0; i < numOfEvents; i++) {
                    MidiEvent event = track.get(i);
                    System.out.println("Event " + i + " - Tick: " + event.getTick());
                }
            }

            for (Track track : tracks) {
                System.out.println(track.size());
            }

        } catch (InvalidMidiDataException | IOException e) {
            System.out.println("Error loading MIDI file");
            System.out.println(e.getMessage());
        }
    }
}
