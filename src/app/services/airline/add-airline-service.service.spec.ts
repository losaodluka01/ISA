import { TestBed, inject } from '@angular/core/testing';

import { AddAirlineServiceService } from './add-airline-service.service';

describe('AddAirlineServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AddAirlineServiceService]
    });
  });

  it('should be created', inject([AddAirlineServiceService], (service: AddAirlineServiceService) => {
    expect(service).toBeTruthy();
  }));
});
