import 'package:flutter_test/flutter_test.dart';
import 'package:smart_alarm/main.dart';

void main() {
  testWidgets('App starts with home screen', (WidgetTester tester) async {
    await tester.pumpWidget(const SmartAlarmApp());
    await tester.pump();

    expect(find.text('GS'), findsOneWidget);
  });
}
