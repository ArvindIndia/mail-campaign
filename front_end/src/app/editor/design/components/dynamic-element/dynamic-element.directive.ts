import { Directive, Input, OnInit, ComponentFactoryResolver, ViewContainerRef, HostListener, SimpleChanges, OnChanges } from '@angular/core';
import { ButtonComponent } from 'src/app/editor/design/components/button/button.component';
import { ImageComponent } from 'src/app/editor/design/components/image/image.component';
import { TextComponent } from 'src/app/editor/design/components/text/text.component';
import { TemplatePlaceholdersService } from 'src/app/editor/services/template-placeholders.service';

const components = {
  button: ButtonComponent,
  image: ImageComponent,
  text: TextComponent
};

@Directive({
  selector: '[dynamicElement]'
})
export class DynamicElementDirective implements OnInit, OnChanges {



  @Input() public section: any;
  @Input() public i: number;
  @Input() public editing: boolean;
  public component: any;

  constructor(private resolver: ComponentFactoryResolver, private container: ViewContainerRef, private templatePlaceholdersService: TemplatePlaceholdersService) { }

  ngOnInit() {
    const component = components[ this.section.type ];
    const factory = this.resolver.resolveComponentFactory<any>(component);
    this.component = this.container.createComponent(factory);
    this.component.instance.section = this.section;
    this.component.instance.i = this.i;
    this.component.instance.editing = this.editing;
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes.hasOwnProperty('section') && !changes.section.firstChange) {
      this.component.instance.section = this.section;
    }
    if (changes.hasOwnProperty('i') && !changes.i.firstChange) {
      this.component.instance.i = this.i;
    }
    if (changes.hasOwnProperty('editing') && !changes.editing.firstChange) {
      this.component.instance.editing = this.editing;
    }
  }

}
