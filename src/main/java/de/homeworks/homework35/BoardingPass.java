package de.homeworks.homework35;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardingPass {
    private String flightNumber;
    private String passengerName;
    private int seatNumber;
}
