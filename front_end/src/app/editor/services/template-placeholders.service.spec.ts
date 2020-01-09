import { TestBed } from '@angular/core/testing';

import { TemplatePlaceholdersService } from './template-placeholders.service';

describe('TemplatePlaceholdersService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TemplatePlaceholdersService = TestBed.get(TemplatePlaceholdersService);
    expect(service).toBeTruthy();
  });
});
