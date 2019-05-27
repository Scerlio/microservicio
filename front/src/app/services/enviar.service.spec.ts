import { TestBed } from '@angular/core/testing';

import { EnviarService } from './enviar.service';

describe('EnviarService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EnviarService = TestBed.get(EnviarService);
    expect(service).toBeTruthy();
  });
});
